import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrls: ['./personal.component.css']
})
export class PersonalComponent implements OnInit {
  account: string;
  personals: any = {
    data: [],
    page: 0,
    size: 0,
    totalPage: 0,
    totalRecord: 0
  }
  personal: any = {
    "role": null,
    "ho": null,
    "ten": null,
    "ngaySinh": null,
    "cmnd": null,
    "caLamViec": null,
    "hinhAnh": null
  }

  constructor(
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService
  ) { }

  personalInfo() {
    this.http.get("http://localhost:8080/api/nhanvien/getNhanVienByKeyword/?page=1&size=2&keyword=" + this.account).subscribe(
      result => {
        let res: any = result;
        this.personals = res;
        this.toastr.success('Bạn không có quyền sửa !!!', 'Lấy thông tin tài khoản thành công');
      },
      error => {
        this.toastr.error('Oh no, Oh no, no no no nầu !', 'Lấy thông tin tài khoản thất bại');
        console.error(error);
      }
    )
  }
  request(){
    this.toastr.error('Oh no, Oh no, no no no nầu !', 'Chức năng này đang được phát triển');
  }

  ngOnInit(): void {
    if (localStorage.getItem("taiKhoanAdmin") == null) {
      this.router.navigate(['/admin/']);
    };
    this.account = localStorage.getItem("taiKhoanAdmin");
    this.personalInfo();
  }

}
