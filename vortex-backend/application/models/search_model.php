<?php
class Search_model extends MY_Model{

	protected $_table_name = 'events';
	protected $_order_by = 'name';
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}

public function search($search_term){
	$this->db->select('*');
		 $this->db->from('events as event, artists as artist, venues as venue');
		 $this->db->like('event.name', $search_term);
		 $this->db->or_like('artist.artist_name', $search_term);
		 $this->db->or_like('venue.name', $search_term);
		//$this->db->join('event_artists', 'event_artists.event_id = events.id');
		 //$this->db->join('event_images', 'event_images.event_id = events.id');
		 //$this->db->join('event_venues', 'event_venues.event_id = events.id');
		 $query = $this->db->get();
		 return $query->result();
		//return $this->get_all();
	}

	public function getEvent($id){
		$this->db->select('
			events.*,
			(select name from venues where id=event_venues.venue_id) as venue,
			(select artist_name from artists where artist_id=event_artists.artist_id) as artist,
			(select url from images where id=event_images.image_id) as images
			');
		 $this->db->join('event_artists', 'event_artists.event_id = events.id');
		 $this->db->join('event_images', 'event_images.event_id = events.id');
		 $this->db->join('event_venues', 'event_venues.event_id = events.id');
		 $this->db->where(array('id' => $id));
	
		$query = $this->db->get();
		$event = $query->row();
		return $this->db->get();
	}

}