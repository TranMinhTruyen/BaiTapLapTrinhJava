import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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

  constructor(private http: HttpClient, private router: Router) { }

  login() {
    console.log("taiKhoan: " + this.data.taiKhoan);
    console.log("matKhau: " + this.data.matKhau);
    this.http.post("/api/nhanvien/loginNhanVien", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.router.navigate(['/admin/login']);
      },
      error => {
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
