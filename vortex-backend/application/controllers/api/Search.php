<?php
class Search extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('search_model');
	}

	public function query(){
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
		echo json_encode($event);
	}

}

	