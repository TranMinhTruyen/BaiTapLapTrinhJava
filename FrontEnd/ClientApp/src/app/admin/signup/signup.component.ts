import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  selectedValue: Number = null;
  caLamViec: Array<any> = [
    {
      value: 1,
      name: "Sáng"
    },
    {
      value: 2,
      name: "Trưa"
    },
    {
      value: 3,
      name: "Chiều"
    },
    {
      value: 4,
      name: "Tối"
    },
  ]
  data: any = {

    "taiKhoan": "",
    "matKhau": "",
    "ho": "",
    "ten": "",
    "cmnd": "",
    "caLamViec": 1
  };

  constructor(
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService) { }

  signup() {
    this.data.caLamViec = this.selectedValue;
    console.log("Ho: " + this.data.ho);
    console.log("Ten: " + this.data.ten);
    console.log("taiKhoan: " + this.data.taiKhoan);
    console.log("matKhau: " + this.data.matKhau);
    console.log("cmnd: " + this.data.cmnd);
    console.log("caLamViec: " + this.data.caLamViec);
    console.log(this.selectedValue);
    this.http.post("http://localhost:8080/api/nhanvien/createNhanVien", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát','Tạo tài khoản thành công');
        this.router.navigate(['/admin/login']);
      },
      error => {
        this.toastr.error('Xin vui lòng tạo tài khoản lại','Tạo tài khoản thất bại');
        console.error(error);
      }
    )
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
