<% request.setAttribute("contextName", request.getContextPath()); %>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" var="username" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
</sec:authorize>
<!DOCTYPE html>
<!-- main.jsp decorator //-->
 <html class="no-js" lang=""> <!--<![endif]-->
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>Gentelella Alela! |</title>

    <!-- Bootstrap -->
    <link href="${contextName}/assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${contextName}/assets/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${contextName}/assets/css/nprogress.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="${contextName}/assets/css/prettify.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${contextName}/assets/css/custom.min.css" rel="stylesheet">
     <!-- jQuery -->
    <script src="${contextName}/assets/js/jquery.min.js"></script>
    <!-- Bootstrap -->
</head>


<body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <%@include file="sidebar.jsp" %>
          
        <%@include file="header.jsp" %>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">

           

            <div class="clearfix"></div>
			<decorator:body/>
            </div>
        </div>
        <!-- /page content -->

        <%@include file="footer.jsp" %>

    <!-- compose -->
    <!-- 
    <div class="compose col-md-6 col-xs-12">
      <div class="compose-header">
        New Message
        <button type="button" class="close compose-close">
          <span>×</span>
        </button>
      </div>

      <div class="compose-body">
        <div id="alerts"></div>

        <div class="btn-toolbar editor" data-role="editor-toolbar" data-target="#editor">
          <div class="btn-group">
            <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="fa fa-font"></i><b class="caret"></b></a>
            <ul class="dropdown-menu">
            </ul>
          </div>

          <div class="btn-group">
            <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li>
                <a data-edit="fontSize 5">
                  <p style="font-size:17px">Huge</p>
                </a>
              </li>
              <li>
                <a data-edit="fontSize 3">
                  <p style="font-size:14px">Normal</p>
                </a>
              </li>
              <li>
                <a data-edit="fontSize 1">
                  <p style="font-size:11px">Small</p>
                </a>
              </li>
            </ul>
          </div>

          <div class="btn-group">
            <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>
            <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>
            <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="fa fa-strikethrough"></i></a>
            <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>
          </div>

          <div class="btn-group">
            <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="fa fa-list-ul"></i></a>
            <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="fa fa-list-ol"></i></a>
            <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="fa fa-dedent"></i></a>
            <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="fa fa-indent"></i></a>
          </div>

          <div class="btn-group">
            <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>
            <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>
            <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>
            <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>
          </div>

          <div class="btn-group">
            <a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="fa fa-link"></i></a>
            <div class="dropdown-menu input-append">
              <input class="span2" placeholder="URL" type="text" data-edit="createLink" />
              <button class="btn" type="button">Add</button>
            </div>
            <a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="fa fa-cut"></i></a>
          </div>

          <div class="btn-group">
            <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="fa fa-picture-o"></i></a>
            <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
          </div>

          <div class="btn-group">
            <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="fa fa-undo"></i></a>
            <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="fa fa-repeat"></i></a>
          </div>
        </div>

        <div id="editor" class="editor-wrapper"></div>
      </div>

      <div class="compose-footer">
        <button id="send" class="btn btn-sm btn-success" type="button">Send</button>
      </div>
    </div> -->
    <!-- /compose -->

   
    <script src="${contextName}/assets/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="${contextName}/assets/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="${contextName}/assets/js/nprogress.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="${contextName}/assets/js/bootstrap-wysiwyg.min.js"></script>
    <script src="${contextName}/assets/js/jquery.hotkeys.js"></script>
    <script src="${contextName}/assets/js/prettify.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="${contextName}/assets/js/custom.min.js"></script>

  </body>
</html>
