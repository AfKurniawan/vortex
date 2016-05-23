<?php
class Venue_model extends MY_Model{

	protected $_table_name = 'venues';
	protected $_order_by = 'name';

	//protected $belongs_to = array('event');

		protected $has_many = array(
		'events'=>array('primary_key'=>'event_id','model'=>'event_model')
			);

	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}