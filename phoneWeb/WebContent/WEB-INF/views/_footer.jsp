<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<footer class="tm-footer row tm-mt-small">
      <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
          Lập trình mạng 17Nh10. 
          <a rel="nofollow noopener" href="https://facebook.com/ndminh1004/" class="tm-footer-link">Nguyễn Đức Minh</a>. Mssv: 102170171
        </p>      </div>
    </footer>
    <script src=".\static\js\jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src=".\static\js\moment.min.js"></script>
    <!-- https://momentjs.com/ -->
    <script src=".\static\js\Chart.min.js"></script>
    <!-- http://www.chartjs.org/docs/latest/ -->
    <script src=".\static\js\bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script src=".\static\js\tooplate-scripts.js"></script>
    <script>
        
        function home() {
        	document.getElementById("t1").className = "nav-link active";
        	document.getElementById("t2").className = "nav-link";
        	document.getElementById("t3").className = "nav-link";
        }
        function list() {
        	document.getElementById("t1").className = "nav-link";
        	document.getElementById("t2").className = "nav-link active";
        	document.getElementById("t3").className = "nav-link";
        }
        function account() {
        	document.getElementById("t1").className = "nav-link";
        	document.getElementById("t2").className = "nav-link";
        	document.getElementById("t3").className = "nav-link active";
        }
    </script>
    