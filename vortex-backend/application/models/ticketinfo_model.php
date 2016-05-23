<?php
class Ticketinfo_model extends MY_Model{

	protected $_table_name = 'ticketinfos';
	protected $_order_by = 'minPrice';

	protected $has_many = array(
		'events'=>array('primary_key'=>'ticketinfo_id','model'=>'event_model')
			);

	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}