<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

  <!-- Begin Page Content -->
  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
              <form class="user" method="POST" action="/register">
                <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user"
                           name="firstName" id="firstName" placeholder="First Name">
                  </div>
                  <div class="col-sm-6">
                    <input type="text" class="form-control form-control-user"
                           name="lastName" id="lastName" placeholder="Last Name">
                  </div>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control form-control-user"
                         name="userName" id="userName" placeholder="Email Address">
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user"
                           name="password" id="password" placeholder="Password">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user"
                           name="confirmPassword" id="confirmPassword" placeholder="Repeat Password">
                  </div>
                </div>
                <button type="submit" class="btn btn-primary btn-user btn-block">
                  Register Account
                </button>
                <hr>
                <a href="#" class="btn btn-google btn-user btn-block">
                  <c:url var="googleImageUrl" value="/img/googleRed.png" />
                  <img src="${googleImageUrl}" /> &nbsp;Register with Google
                </a>
                <a href="#" class="btn btn-facebook btn-user btn-block">
                  <c:url var="fbImageUrl" value="/img/facebook.png" />
                  <img src="${fbImageUrl}" /> &nbsp;Register with Facebook
                </a>
              </form>
              <hr>
              <div class="text-center">
                <a class="small" href="/forgot-password">Forgot Password?</a>
              </div>
              <div class="text-center">
                <a class="small" href="/login">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
  <!-- End of Page Content -->

<c:import url="/WEB-INF/jsp/footer.jsp" />