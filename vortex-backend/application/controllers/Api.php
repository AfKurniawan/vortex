<?php
class Api extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('event_model');
		$this->load->model('artist_model');
		$this->load->model('image_model');
		$this->load->model('search_model');
	}

	public function events(){
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

	public function autoSuggest(){
		$query = $this->input->post('query');
		$data = $this->search_model->search($query);
		$search_results = array();

		if (count($data)) {
				$search_results['message'] = 'Success';
				$search_results['success'] = true;
				$search_results['results'] = $data;
		}else{
				$search_results['message'] = 'no results';
				$search_results['success'] = false;
				$search_results['results'] = null;
		}
		echo json_encode($search_results);
	}

	public function event(){

		$id = $this->input->post('id');

		$data = $this->event_model->with('venue')->with('ticketinfo')->getEvent2($id);
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

	public function artists(){

		$limit = $this->input->post('limit');
		$offset = $this->input->post('offset');

		$data = $this->artist_model->getAllArtists();

		$artists = array();
		if (count($data)) {
				$artists['numFound'] =  count($data);
				$artists['limit'] = $limit;
				$artists['offset'] = $offset;
				$artists['artists'] = $data;
		}else{
				$artists['numFound'] =  count($data);
				$artists['limit'] = $limit;
				$artists['offset'] = $offset;
				$artists['artists'] = null;
		}
		echo json_encode($artists);
	}

	public function images(){

		$limit = $this->input->post('limit');
		$offset = $this->input->post('offset');

		$data = $this->image_model->images();

		$images = array();
		if (count($data)) {
				$images['numFound'] =  count($data);
				$images['limit'] = $limit;
				$images['offset'] = $offset;
				$images['images'] = $data;
		}else{
				$images['numFound'] =  count($data);
				$images['limit'] = $limit;
				$images['offset'] = $offset;
				$images['images'] = null;
		}
		echo json_encode($images);
	}

	public function artist(){

		$artist_id = $this->input->post('id');

		$data = $this->artist_model->with('genre')->artist($artist_id);
		$artists = array();

		if (count($data)) {
				$artists['numFound'] = count($data);
				$artists['numReturned'] = count($data);
				$artists['artists'] = $data;
		}else{
				$artists['numFound'] = count($data);
				$artists['numReturned'] = count($data);
				$artists['artists'] = null;
		}
		echo json_encode($artists);
	}

}

	