<?php
class Event_venue_model extends MY_Model{

	protected $_table_name = 'event_venues';
	protected $_order_by = 'name';

	protected $belongs_to = array('event');
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}