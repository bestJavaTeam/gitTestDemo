
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>用户注册</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		
		<style type="text/css">
		.modal-footer {   border-top: 0px; }
		</style>
	</head>
	<body>
<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h1 class="text-center">用户注册</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" action="RegisterService" method="post" ><!-- enctype="multipart/form-data"  enctype="application/x-www-form-urlencoded" -->
            <div class="form-group">
            <label>用户名</label>
              <input type="text" name="userName" class="form-control input-lg" placeholder="用户名">
            </div>
             <div class="form-group">
            <label>id</label>
              <input type="text" name="id" class="form-control input-lg" placeholder="id">
            </div>
             <div class="form-group">
            <label>信息</label>
              <input type="text" name="info" class="form-control input-lg" placeholder="info">
            </div>
             <div class="form-group">
            <label>acator</label>
              <input type="text" name="avator" class="form-control input-lg" placeholder="acator">
            </div>
            <div class="form-group">
            <label>密码</label>
              <input type="password" name="pwd" class="form-control input-lg" placeholder="密码">
            </div>
            <div class="form-group">
            <label>电话号码</label>
              <input type="text" name="phone" class="form-control input-lg" placeholder="电话号码">
            </div>
            <div class="form-group">
            <label>邮箱</label>
              <input type="text" name="email" class="form-control input-lg" placeholder="邮箱">
            </div>
            <div class="form-group">
            <label>qq</label>
              <input type="text" name="qq" class="form-control input-lg" placeholder="qq">
            </div>
         <div class="btn-group pull-right">
         <button class="reset btn btn-default">重置</button>
          <button class="submit btn btn-primary">注册</button>
		  </div>	
          </form>
      </div>
      <div class="modal-footer">
        
      </div>
  </div>
  </div>
</div>
	<!-- script references -->
		<script type='text/javascript' src="js/jquery-1.9.1.min.js"></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
		
	</body>
</html>