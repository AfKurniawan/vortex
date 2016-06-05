package com.creativedna.vortex.ui.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.creativedna.vortex.R;
import com.creativedna.vortex.constants.AppConstants;
import com.creativedna.vortex.helpers.FbConnectHelper;
import com.creativedna.vortex.helpers.GooglePlusSignInHelper;
import com.creativedna.vortex.helpers.SharedPreferenceManager;
import com.creativedna.vortex.models.UserModel;
import com.creativedna.vortex.ui.activities.LandingPage;
import com.creativedna.vortex.ui.activities.LoginActivity;
import com.creativedna.vortex.ui.activities.SignupActivity;
import com.facebook.GraphResponse;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class LoginFragment extends Fragment implements FbConnectHelper.OnFbSignInListener, GooglePlusSignInHelper.OnGoogleSignInListener{
    private static final String TAG = LoginFragment.class.getSimpleName();
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_login) Button _loginButton;
    @Bind(R.id.link_signup) TextView _signupLink;


    ProgressDialog progressDialog ;

    @Bind(R.id.login_layout)
    LinearLayout view;

    private FbConnectHelper fbConnectHelper;
    private GooglePlusSignInHelper gSignInHelper;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


        progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivityForResult(intent, LoginActivity.REQUEST_SIGNUP);
            }
        });

        setup();
    }

    private void setup() {

        GooglePlusSignInHelper.setClientID(AppConstants.GOOGLE_CLIENT_ID);
        gSignInHelper = GooglePlusSignInHelper.getInstance();
        gSignInHelper.initialize(getActivity(), this);

        fbConnectHelper = new FbConnectHelper(this,this);
    }

    @OnClick(R.id.login_google)
    public void loginwithGoogle(View view) {
        gSignInHelper.signIn(getActivity());
        setBackground(R.color.g_color);
    }

    @OnClick(R.id.login_facebook)
    public void loginwithFacebook(View view) {
        fbConnectHelper.connect();
        setBackground(R.color.fb_color);
    }



    private void setBackground(int colorId)
    {
//        getView().setBackgroundColor(getActivity().getResources().getColor(colorId));
//        progressBar.setVisibility(View.VISIBLE);
        progressDialog.show();
        view.setVisibility(View.GONE);
    }

    private void resetToDefaultView(String message)
    {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//        getView().setBackgroundColor(getActivity().getResources().getColor(R.color.primary));
//        progressBar.setVisibility(View.GONE);
        progressDialog.dismiss();
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fbConnectHelper.onActivityResult(requestCode, resultCode, data);
        gSignInHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void OnFbSuccess(GraphResponse graphResponse) {
        UserModel userModel = getUserModelFromGraphResponse(graphResponse);
        if(userModel!=null) {
            SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
            startHomeActivity(userModel);
        }
    }

    private UserModel getUserModelFromGraphResponse(GraphResponse graphResponse)
    {
        UserModel userModel = new UserModel();
        try {
            JSONObject jsonObject = graphResponse.getJSONObject();
            userModel.userName = jsonObject.getString("name");
            userModel.userEmail = jsonObject.getString("email");
            String id = jsonObject.getString("id");
//            String profileImg = "http://graph.facebook.com/"+ id+ "/picture?type=large";
            String profileImg = "http://pcwallart.com/images/generic-avatar-icon-wallpaper-2.jpg";

            ImageRequest request = getImageRequest(id);
            if (request != null) {
                profileImg = request.getImageUri().toString();
            }

            userModel.profilePic = profileImg;
            Log.i(TAG,profileImg);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return userModel;
    }

    private ImageRequest getImageRequest(String id) {
        ImageRequest request = null;
        ImageRequest.Builder requestBuilder = new ImageRequest.Builder(
                getActivity(),
                ImageRequest.getProfilePictureUri(id,
                        getResources().getDimensionPixelSize(
                                R.dimen.profileImageSize),
                        getResources().getDimensionPixelSize(
                                R.dimen.profileImageSize)));

        request = requestBuilder.setCallerTag(this)
                .setCallback(
                        new ImageRequest.Callback() {
                            @Override
                            public void onCompleted(ImageResponse response) {

                            }
                        })
                .build();
        return request;
    }
    @Override
    public void OnFbError(String errorMessage) {
        resetToDefaultView(errorMessage);
    }

    @Override
    public void OnGSignSuccess(GoogleSignInAccount acct) {
        UserModel userModel = new UserModel();
        userModel.userName = (acct.getDisplayName()==null)?"":acct.getDisplayName();
        userModel.userEmail = acct.getEmail();

        Uri photoUrl = acct.getPhotoUrl();
        if(photoUrl!=null)
            userModel.profilePic = photoUrl.toString();
        else
            userModel.profilePic = "";
        Log.i(TAG, acct.getIdToken());

        SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
        startHomeActivity(userModel);
    }

    @Override
    public void OnGSignError(GoogleSignInResult errorMessage) {
        resetToDefaultView("Google Sign in error");
    }

    private void startHomeActivity(UserModel userModel)
    {
        Intent intent = new Intent(getActivity(), LandingPage.class);
        intent.putExtra(UserModel.class.getSimpleName(), userModel);
        startActivity(intent);
//        getActivity().finishAffinity();
        getActivity().finish();
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);



        progressDialog.show();

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
       new LoginAsync().execute(email, password);

    }



        class LoginAsync extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                String pass = params[1];

                String result = "";

                try {
                    OkHttpClient httpClient = new OkHttpClient();

                    RequestBody formBody = new FormBody.Builder()
                            .add("email", uname)
                            .add("password", pass)
                            .build();

                    Request request = new Request.Builder()
                            .url(AppConstants.LOGIN_URL)
                            .post(formBody)
                            .build();


                    Response response = httpClient.newCall(request).execute();
                    if (!response.isSuccessful())
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "Login Server Error", Toast
                                        .LENGTH_SHORT).show();
                            }
                        });
                    result = response.body().string();


                }  catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                progressDialog.dismiss();
                if(s.equalsIgnoreCase("failure") || s.equalsIgnoreCase("")){
                    onLoginFailed();
                }else {
                    onLoginSuccess(result);

                }
                Log.i(TAG,result);
//                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
            }
        }


    public void onLoginSuccess(String result) {
        _loginButton.setEnabled(true);
        try {
            JSONObject json = new JSONObject(result);
            String username = json.getString("name");
            String email = json.getString("email");

            UserModel userModel = new UserModel();
            userModel.userName = username;
            userModel.userEmail = email;

            Uri photoUrl = null;
            if(photoUrl!=null)
                userModel.profilePic = photoUrl.toString();
            else
                userModel.profilePic = "";

            SharedPreferenceManager.getSharedInstance().saveUserModel(userModel);
            startHomeActivity(userModel);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onLoginFailed() {

     Toast.makeText(getActivity(), "Login failed, check your credentials", Toast.LENGTH_LONG)
                .show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

}
