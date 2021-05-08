import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  form = new FormGroup({
    ho: new FormControl('', [Validators.required, Validators.maxLength(8)]),
    ten: new FormControl('', [Validators.required, Validators.maxLength(8)]),
    taiKhoan: new FormControl('', [Validators.required, Validators.maxLength(16)]),
    matKhau: new FormControl('', [Validators.required,Validators.minLength(6)])
  })

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
  clv: any ={
    "id": "",
    "caLam": ""
  }
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
    //this.data.caLamViec = this.selectedValue;
    console.log("Ho: " + this.data.ho);
    console.log("Ten: " + this.data.ten);
    console.log("taiKhoan: " + this.data.taiKhoan);
    console.log("matKhau: " + this.data.matKhau);
    console.log("cmnd: " + this.data.cmnd);
    console.log("caLamViec: " + this.data.caLamViec);
    //console.log(this.selectedValue);

    // this.http.post("http://localhost:8080/api/nhanvien/createNhanVien", this.data).subscribe(
    //   result => {
    //     let res: any = result;
    //     console.log(res);
    //     this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát', 'Tạo tài khoản thành công');
    //     this.router.navigate(['/admin/login']);
    //   },
    //   error => {
    //     this.toastr.error('Xin vui lòng tạo tài khoản lại', 'Tạo tài khoản thất bại');
    //     this.toastr.info('Kiểm tra xem đã chọn ca làm việc chưa ?');
    //     console.error(error);
    //   }
    // )

  }

  ngOnInit() {
    // window.addEventListener("beforeunload", function (e) {
    //   var confirmationMessage = "\o/";
    //   console.log("cond");
    //   e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
    //   return confirmationMessage;              // Gecko, WebKit, Chrome <34
    // });
    if(localStorage.getItem("taiKhoanAdmin") != null){
      this.router.navigate(['/admin/']);
    }
    this.getClv(5,1);
  }
  getClv(size: number, page: number) {
    this.http.get<any>('http://localhost:8080/api/calamviec/getAllCaLamViec/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.clv = response;
      }
    );
  };

  onSubmit(form: FormGroup): void {
    console.log(form);
  }



}
