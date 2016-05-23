<?php
class Artist_genre_model extends MY_Model{

	protected $_table_name = 'artist_genres';
	protected $_order_by = 'artist_id';
	

	protected $belongs_to = array('artist');
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}
}