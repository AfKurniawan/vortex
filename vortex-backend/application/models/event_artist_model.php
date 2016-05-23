<?php
class Event_artist_model extends MY_Model{

	protected $_table_name = 'event_artists';
	protected $_order_by = 'event_id';

	protected $belongs_to = array('event');
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}