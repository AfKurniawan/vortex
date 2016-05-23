<?php
class Artist_model extends MY_Model{

	protected $_table_name = 'artists';
	protected $_order_by = 'name';

	//protected $belongs_to = array('event');
	protected $has_many = array(
		'artist_images'=>array('primary_key'=>'artist_id','model'=>'Artist_image_model'), 
		'event_artists'=>array('primary_key'=>'event_id','model'=>'Event_artist_model'), 
		'artist_genres'=>array('primary_key'=>'artist_id','model'=>'Artist_genre_model')
			);
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}

	public function getAllArtists($limit=null, $start=null){
		$this->db->select('*');
		$this->db->from('artists');
		$this->db->limit($limit, $start);
		$query = $this->db->get();


		if ($query->num_rows()>0) {
			$artists = $query->result();
			foreach ($artists as $artist) {
				$genres = $this->getArtistGenre($artist->id);
				$artist->genres = $genres;
				$artist->urls = $this->getArtistUrls($artist->id);
				$artist->images = $this->getArtistImages($artist->id);
			}
			return $artists;
		}else{
			return false;
		}
	}

	public function getArtist($artist_id){
			$this->db->select ( '*' );
		$this->db->from ( $this->_table_name );
		$this->db->where(array('id' => $artist_id));

		$query = $this->db->get();
		$artist = $query->result();

		$genres = $this->getArtistGenre($artist->id);

		$artist->genre = $genres;

		return $artist;
	}
	public function artist($artist_id){
		return $this->get($artist_id);
	}

	public function getArtistGenre($artist_id){
		$this->db->select('*');
		$this->db->from('artist_genres');
		$this->db->where(array('artist_genres.artist_id' => $artist_id));
		$query = $this->db->get();

		$artist_genres = $query->result();

		$data = array();
		foreach ($artist_genres as $artist_genre) {
			array_push($data, $this->getGenreName($artist_genre->genre_id));
		}

		return $data;
	}

	public function getGenreName($genre_id){
		$this->db->select('*');
		$this->db->from('genres');
		$this->db->where(array('id' => $genre_id));
		$query = $this->db->get();


		if ($query->num_rows()>0) {
			$genre = $query->result()[0];
			return $genre->genre;
		}


		return "";
	}

	public function getArtistUrls($artist_id){
		$this->db->select('*');
		$this->db->from('urls');
		$this->db->where(array('urls.artist_id' => $artist_id));
		$query = $this->db->get();

		if ($query->num_rows()>0) {
			return $query->result()[0];
		}

		return null;
	}

	public function getArtistImages($artist_id){
		$this->db->select('*');
		$this->db->from('artist_images');
		$this->db->where(array('artist_images.artist_id' => $artist_id));
		$query = $this->db->get();

		$artist_images = $query->result();

		$data = array();
		foreach ($artist_images as $artist_image) {
			array_push($data, $this->getImage($artist_image->image_id));
		}

		return $data;
	}

	public function getImage($image_id){
		$this->db->select('*');
		$this->db->from('images');
		$this->db->where(array('id' => $image_id));
		$query = $this->db->get();


		if ($query->num_rows()>0) {
			$image = $query->result()[0];
			return $image;
		}


		return null;
	}
}