package com.creativedna.vortex.ui.adapters.ViewHolders;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.colintmiller.simplenosql.NoSQL;
import com.colintmiller.simplenosql.NoSQLEntity;
import com.creativedna.vortex.R;
import com.creativedna.vortex.constants.AppConstants;
import com.creativedna.vortex.data.API;
import com.creativedna.vortex.data.RetrofitAdapter;
import com.creativedna.vortex.data.callbacks.EventCallback;
import com.creativedna.vortex.helpers.SharedPreferenceManager;
import com.creativedna.vortex.models.Event;
import com.creativedna.vortex.models.Ticket;
import com.creativedna.vortex.models.UserModel;
import com.creativedna.vortex.utils.DataFormatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class TicketsViewHolder extends RecyclerView.ViewHolder {

    Ticket ticket;
    Context context;
    @Bind(R.id.tvEventTicketTitle)
    TextView tvEventTicketTitle;

    @Bind(R.id.tvEvent_details_ticket_code)
    TextView tvTicketCurrencyCode;

    @Bind(R.id.tvEventTicketsExpiry)
    TextView tvEventTicketsExpiry;

    @Bind(R.id.tvEvent_details_ticket_amount)
    TextView tvTicketAmount;

    @Bind(R.id.tvEventBook)
    TextView rlEventBooking;

    @Bind(R.id.rlTicketEvent)
    MaterialRippleLayout mBookingView;

    @Bind(R.id.tvTicketQuantity)
    TextView tvTicketQuantity;

    public TicketsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void renderView(final Context context, final Ticket ticket) {
        tvEventTicketTitle.setText(ticket.getType());
        String time = "Expires on - ";
        this.context = context;
        this.ticket = ticket;

        if (ticket.getDeadline() != null)
            time += DataFormatter.formatDate(ticket.getDeadline());
        else time +="not specified";
        tvEventTicketsExpiry.setText(time);

        tvTicketCurrencyCode.setText(ticket.getCurrencyCode());

        tvTicketQuantity.setText(ticket.getTotalAvailable() + " left");

        tvTicketAmount.setText(ticket.getAmount());

        mBookingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Booked!", Toast.LENGTH_SHORT).show();
//                rlEventBooking.setText("Booked");
//                tvTicketQuantity.setText((Integer.parseInt(ticket.getTotalAvailable()) - 1) + " left");

                String quantity = 1+"";
                String ticketID = ticket.getTicket_id();
                String eventID = ticket.getEvent_id();
                Log.d("TICKETS","Ticket ID = "+ticketID);
                UserModel model = SharedPreferenceManager.getSharedInstance()
                        .getUserModelFromPreferences();
                String userID = model.userID;


                new BookTicket().execute(quantity,userID,ticketID,eventID);

            }
        });
    }


    class BookTicket extends AsyncTask<String, Void, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            Toast.makeText(context, "Booking..", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s.contains("Successfully booked")) {
                onBookingSuccess();
//                Toast.makeText(context, "Booked", Toast.LENGTH_SHORT)
//                        .show();
            }else {
                Log.i("TICKET", s);
                Toast.makeText(context, "Booking Failed, try again later", Toast.LENGTH_SHORT)
                        .show();
            }


        }

        @Override
        protected String doInBackground(String... params) {

            HashMap<String, String> data = new HashMap<>();
            data.put("qnty",params[0]);
            data.put("userID",params[1]);
            data.put("ticketID",params[2]);
            data.put("eventID",params[3]);


            String result = sendPostRequest(AppConstants.BOOKING_URL,data);

            return  result;
        }
    }

    private void onBookingSuccess() {
        Toast.makeText(context, "Booked", Toast.LENGTH_SHORT)
                        .show();

        SharedPreferenceManager.getSharedInstance().getUserModelFromPreferences();
//                        rlEventBooking.setText("Booked");
        tvTicketQuantity.setText((Integer.parseInt(ticket.getTotalAvailable()) - 1) + " left");
        getEvents();


    }

    private void getEvents() {


        //API
        API api = RetrofitAdapter.createAPI();
        Observable<EventCallback> eventCallbackObservable = api.getEvents();
        eventCallbackObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .filter(new Func1<EventCallback, Boolean>() {
                    @Override
                    public Boolean call(EventCallback eventCallback) {
                        return eventCallback.getNumFound() != 0;
                    }
                })
                .subscribe(new Subscriber<EventCallback>() {
                    @Override
                    public void onCompleted() {

                        Log.d("getting events...", "Completed");

                    }

                    @Override
                    public void onError(Throwable e) {
                        //  Toast.makeText(getActivity(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("Allevents Frag error", e.toString());
                        String error = String.format("%s", "Error occurred!");

                    }

                    @Override
                    public void onNext(EventCallback eventCallback) {
                        if(eventCallback.getEvents().size()>0){
                            for(int i=0;i<eventCallback.getEvents().size();i++){
                                save(eventCallback.getEvents().get(i));
                            }
                        }
                    }
                });
    }

    public void save(Event event) {
        NoSQLEntity<Event> entity = new NoSQLEntity<Event>("events", event.getId() + "");
        entity.setData(event);
        NoSQL.with(context).using(Event.class).save(entity);
    }

    public String sendPostRequest(String requestURL,
                                  HashMap<String, String> postDataParams) {

        URL url;
        String response = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                response = br.readLine();
            }
            else {
                response="Error Booking";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
