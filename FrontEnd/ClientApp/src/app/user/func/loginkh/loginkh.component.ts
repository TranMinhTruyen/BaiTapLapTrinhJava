import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService} from 'ngx-toastr';
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-loginkh',
  templateUrl: './loginkh.component.html',
  styleUrls: ['./loginkh.component.css']
})
export class LoginkhComponent implements OnInit {
  id: string;
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
    this.http.post("http://localhost:8080/api/khachhang/loginKhachHang/", this.data).subscribe(
      result => {
        let res: any = result;
        this.id = res.id;
        console.log(res);
        this.router.navigate(['/user/login']);
        if (localStorage) {
          localStorage.setItem("taiKhoanKhachHang", this.data.taiKhoan);
          localStorage.setItem("idKhachHang", this.id);
          this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát','Đăng nhập thành công');
          this.toastr.info('Xin chào ' + localStorage.getItem("taiKhoanKhachHang"));
          this.toastr.info('Xin chào ' + localStorage.getItem("idKhachHang"));
          this.router.navigate(['/user/']);
        } else {
          this.toastr.error('Xin vui lòng đăng nhập lại','Đăng nhập thất bại');
          this.toastr.info('Xin lỗi ' + localStorage.getItem("taiKhoanKhachHang"));
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


  ngOnInit(): void {
    if(localStorage.getItem("taiKhoanKhachHang") != null){
      this.router.navigate(['/user/']);
    }
  }

}
