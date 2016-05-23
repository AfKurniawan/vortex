<?php
class Image_model extends MY_Model{

	protected $_table_name = 'images';
	protected $_order_by = 'url';
	
	protected $has_many = array(
		'artist_images'=>array('primary_key'=>'image_id','model'=>'artist_image_model'), 
		'event_images'=>array('primary_key'=>'image_id','model'=>'venue_image_model')
			);
	
	function __construct (){
			parent::__construct();
			$this->_database = $this->db;
	}

	public function images($limit=null, $start=null){
		return $this->get_all();
	}
}