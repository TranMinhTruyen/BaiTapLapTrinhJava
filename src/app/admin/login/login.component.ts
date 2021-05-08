import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form = new FormGroup({
    taiKhoan: new FormControl('', Validators.required),
    matKhau: new FormControl('', [Validators.required,Validators.minLength(6)])
  })

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
    this.http.post("http://localhost:8080/api/nhanvien/loginNhanVien/", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.router.navigate(['/admin/login']);
        if (localStorage) {
          localStorage.setItem("taiKhoanAdmin", this.data.taiKhoan);
          this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát', 'Đăng nhập thành công');
          this.toastr.info('Xin chào ' + localStorage.getItem("taiKhoanAdmin"));
          this.router.navigate(['/admin/']);
        } else {
          this.toastr.error('Xin vui lòng đăng nhập lại', 'Đăng nhập thất bại');
          this.toastr.info('Xin lỗi ' + localStorage.getItem("taiKhoanAdmin"));
        }
      },
      error => {
        console.log(error);
        this.toastr.error('Xin vui lòng đăng nhập lại', 'Đăng nhập thất bại');
      }
    )
  }

  showToast() {
    this.toastr.success('adudu', 'ahihi');
    this.toastr.error('csd', 'sdasd');
    this.toastr.info('asdasd', 'asdihauisd');
  }

  ngOnInit() {
    // window.addEventListener("beforeunload", function (e) {
    //   var confirmationMessage = "\o/";
    //   console.log("cond");
    //   e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
    //   return confirmationMessage;              // Gecko, WebKit, Chrome <34
    // });
    if (localStorage.getItem("taiKhoanAdmin") != null) {
      this.router.navigate(['/admin/']);
    }
  }

}
