<?php
class Event_model extends MY_Model{

	protected $_table_name = 'events';
	protected $_order_by = 'name';

	protected $belongs_to = array('venue','ticketinfo');

	protected $has_many = array(
		'event_images'=>array('primary_key'=>'event_id','model'=>'event_image_model'), 
		'event_artists'=>array('primary_key'=>'event_id','model'=>'event_artist_model')
			);

	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}

public function getEvents($limit=0, $start=0){
	$this->db->select('
			events.id, 
			events.name as event_name, 
			events.eventDateLocal, 
			events.venue_id, 
			events.ticketinfo_id,


			artists.id, 
			artists.artist_name as artist_name, 
			artists.description, 
			artists.description_source

			');
		 $this->db->join('event_artists', 'events.id = event_artists.event_id','left');
		 $this->db->join('artists', 'event_artists.artist_id = artists.id','left');
		 $this->db->limit($limit, $start);
		return $this->get_all();
	}

	public function events($limit=null, $start=null){
		$this->db->select('*');
		$this->db->from('events');
		$query = $this->db->get();
		if ($query->num_rows()>0) {
			$events = $query->result();
			foreach ($events as $event) {
				$artists = $this->getEventArtists($event->id);
				$images = $this->getEventImages($event->id);
				$venue = $this-> getEventVenue($event->venue_id);
				$ticketinfo = $this-> getEventTicketInfo($event->venue_id);
				$event->artists = $artists;
				$event->images = $images;
				$event->venue = $venue;
				$event->ticketinfo = $ticketinfo;
				$event->imageUrl = base_url() . '/assets/uploads/files/'.$event->imageUrl;
			}
			return $events;
		}else{
			return false;
		}
	}

	public function getEventArtists($artist_id){
		$this->db->select('*');
    	$this->db->from('artists');
    	$this->db->join('event_artists', 'artists.id = event_artists.artist_id');
		$this->db->join('events', 'event_artists.event_id = events.id');
    	$this->db->where(array('event_artists.event_id' => $artist_id));
    	$query = $this->db->get();
    	
    	return $query->result();
	}
	public function getEventVenue($venue_id){
		$this->db->select('*');
    	$this->db->from('venues');
		$this->db->join('events', 'events.venue_id = venues.id','left');
    	$this->db->where(array('venues.id' => $venue_id));
    	$query = $this->db->get();
    	
    	return $query->row();
	}
	public function getEventTicketInfo($ticketinfo_id){
		$this->db->select('*');
    	$this->db->from('ticketinfos');
		$this->db->join('events', 'events.ticketinfo_id = ticketinfos.id','left');
    	$this->db->where(array('ticketinfos.id' => $ticketinfo_id));
    	$query = $this->db->get();
    	
    	return $query->row();
	}
	public function getEventImages($image_id){
		$this->db->select('*');
    	$this->db->from('images');
    	$this->db->join('event_images', 'images.id = event_images.image_id');
		$this->db->join('events', 'event_images.event_id = events.id');
    	$this->db->where(array('event_images.event_id' => $image_id));
    	$query = $this->db->get();
    	
    	return $query->result();
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

	public function getEvent2($id){
		return $this->get($id);
	}

}