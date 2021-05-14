import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-signupkh',
  templateUrl: './signupkh.component.html',
  styleUrls: ['./signupkh.component.css']
})
export class SignupkhComponent implements OnInit {
  form = new FormGroup({
    ho: new FormControl('', [Validators.required, Validators.maxLength(8)]),
    ten: new FormControl('', [Validators.required, Validators.maxLength(8)]),
    taiKhoan: new FormControl('', [Validators.required, Validators.maxLength(16)]),
    matKhau: new FormControl('', [Validators.required,Validators.minLength(6)]),
    ngaySinh: new FormControl('', [Validators.required,Validators.minLength(9)])
  })

  ngOnInit(): void {
    if(localStorage.getItem("taiKhoanKhachHang") != null){
      this.router.navigate(['/user/']);
    }
  }
  data: any = {

    "taiKhoan": "",
    "matKhau": "",
    "ho": "",
    "ten": "",
    "cmnd": "",
    "ngaySinh": "YYYY-MM-DD"
  };

  constructor(
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService) { }

  signup() {
    console.log("Ho: " + this.data.ho);
    console.log("Ten: " + this.data.ten);
    console.log("taiKhoan: " + this.data.taiKhoan);
    console.log("matKhau: " + this.data.matKhau);

    this.http.post("http://localhost:8080/api/khachhang/createKhachHang", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát', 'Tạo tài khoản thành công');
        this.router.navigate(['/user/login']);
      },
      error => {
        this.toastr.error('Xin vui lòng tạo tài khoản lại', 'Tạo tài khoản thất bại');
        console.error(error);
      }
    )

  }
}
