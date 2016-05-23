<?php
class Artist_image_model extends MY_Model{

	protected $_table_name = 'artist_images';
	protected $_order_by = 'artist_id';
	

	protected $belongs_to = array('artist');
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}