<!DOCTYPE html>
<html lang="en">
	
<head>
		<title>Maruti Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/maruti-style.css" />
		<link rel="stylesheet" href="css/maruti-media.css" class="skin-color" />	
	</head>
	<body>
		
<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Maruti Admin</a></h1>
</div>
<!--close-Header-part--> 

<!--top-Header-messaages-->
<div class="btn-group rightzero"> <a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a> <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a> <a class="top_message tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a> <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a> </div>
<!--close-top-Header-messaages--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse"><ul class="nav">
    <li class="" ><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
    <li class=" dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#">new message</a></li>
        <li><a class="sInbox" title="" href="#">inbox</a></li>
        <li><a class="sOutbox" title="" href="#">outbox</a></li>
        <li><a class="sTrash" title="" href="#">trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-left" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-Header-menu-->
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-file"></i> Gallery</a>
			<ul>
    <li class="active"><a href="index.html"><i class="icon icon-home"></i> <span>Dashboard</span></a></li>
    <li> <a href="charts.html"><i class="icon icon-signal"></i> <span>Charts &amp; graphs</span></a> </li>
    <li> <a href="widgets.html"><i class="icon icon-inbox"></i> <span>Widgets</span></a> </li>
    <li><a href="tables.html"><i class="icon icon-th"></i> <span>Tables</span></a></li>
    <li><a href="grid.html"><i class="icon icon-fullscreen"></i> <span>Full width</span></a></li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Forms</span> <span class="label">3</span></a>
      <ul>
        <li><a href="form-common.html">Basic Form</a></li>
        <li><a href="form-validation.html">Form with Validation</a></li>
        <li><a href="form-wizard.html">Form with Wizard</a></li>
      </ul>
    </li>
    <li><a href="buttons.html"><i class="icon icon-tint"></i> <span>Buttons &amp; icons</span></a></li>
    <li><a href="interface.html"><i class="icon icon-pencil"></i> <span>Eelements</span></a></li>
    
    <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Addons</span> <span class="label">3</span></a>
      <ul>
        <li><a href="gallery.html">Gallery</a></li>
        <li><a href="calendar.html">Calendar</a></li>
        <li><a href="chat.html">Chat option</a></li>
      </ul>
    </li>

  </ul>
		
		</div>
		
	
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#">Sample pages</a>
				<a href="#" class="current">Gallery</a>
			</div>
                <h1>Gallery</h1>
			</div>
			
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-picture"></i>
								</span>
								<h5>Gallery</h5>
							</div>
							<div class="widget-content">
                            <ul class="thumbnails">
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span2">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
								</ul>
								<ul class="thumbnails">
									
                                    <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                     <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox3.jpg">
											<img src="images/gallery/imgbox3.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox4.jpg">
											<img src="images/gallery/imgbox4.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox5.jpg">
											<img src="images/gallery/imgbox5.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
									
                                    	 <li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox1.jpg">
											<img src="images/gallery/imgbox1.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                   
									<li class="span1">
										<a class="thumbnail lightbox_trigger" href="images/gallery/imgbox2.jpg">
											<img src="images/gallery/imgbox2.jpg" alt="" >
										</a>
										<div class="actions">
											<a title="" href="#"><i class="icon-pencil icon-white"></i></a>
											<a title="" href="#"><i class="icon-remove icon-white"></i></a>
										</div>
									</li>
                                  </ul>
							</div>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
		
		 <div class="row-fluid">
      <div id="footer" class="span12"> 2012 &copy; Marutii Admin. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> </div>
    </div>
            
            <script src="js/jquery.min.js"></script>
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/maruti.js"></script>
            
	</body>

</html>
