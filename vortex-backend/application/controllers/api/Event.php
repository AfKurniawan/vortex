<?php
class Event extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('event_model');
		$this->load->model('event_artist_model');
		$this->load->model('event_image_model');
		$this->load->model('event_venue_model');
	}

	public function getEvents(){
		$limit = $this->input->post('limit');
		$offset = $this->input->post('offset');

		$data = $this->event_model->with('venue')->with('ticketinfo')->events();
		$events = array();

		if (count($data)) {
				$events['numFound'] = count($data);
				$events['limit'] = $limit;
				$events['offset'] = $offset;
				$events['events'] = $data;
		}else{
				$events['numFound'] = count($data);
				$events['limit'] = $limit;
				$events['offset'] = $offset;
				$events['events'] = null;
		}
		echo json_encode($events);
	}

	public function getEvent(){

		$id = $this->input->post('id');

		$data = $this->event_model->getEvent($id);
		$event = array();

		if (count($data)) {
				$event['message'] = 'Success';
				$event['success'] = true;
				$event['event'] = $data;
		}else{
				$event['message'] = 'no event';
				$event['success'] = false;
				$event['event'] = null;
		}
		echo json_encode($data);
	}

}

	