import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  data: any = {
    "taiKhoan": "",
    "matKhau": ""
  };

  constructor(
     private http: HttpClient,
     private router: Router,
     private toastr: ToastrService) { }

  login() {
    console.log("taiKhoan: " + this.data.taiKhoan);
    console.log("matKhau: " + this.data.matKhau);
    this.http.post("/api/nhanvien/loginNhanVien/", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.router.navigate(['/admin/login']);
        if (localStorage) {
          localStorage.setItem("taiKhoan", this.data.taiKhoan);
          this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát','Đăng nhập thành công');
        } else {
          this.toastr.error('Xin vui lòng đăng nhập lại','Đăng nhập thất bại');
        }
      },
      error => {
        console.log(error);
        this.toastr.error('Xin vui lòng đăng nhập lại','Đăng nhập thất bại');
      }
    )
  }

  showToast(){
    this.toastr.success('adudu','ahihi');
    this.toastr.error('csd','sdasd');
    this.toastr.info('asdasd','asdihauisd');
  }

  ngOnInit() {
    window.addEventListener("beforeunload", function (e) {
      var confirmationMessage = "\o/";
      console.log("cond");
      e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
      return confirmationMessage;              // Gecko, WebKit, Chrome <34
    });
  }

}
