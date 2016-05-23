<?php
class Artist extends CI_Controller
{

	public function __construct ()
	{
		parent::__construct();
		$this->load->model('artist_model');
		$this->load->model('artist_genre_model');
		$this->load->model('artist_image_model');
	}

	public function getAllArtists(){

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

	public function getArtist($artist_id){
		$data = $this->artist_model->getArtist($artist_id);
		echo $artist_id;

		echo json_encode($data);
	}

	public function hello($artist_id){
		echo 'hi';
	}

}