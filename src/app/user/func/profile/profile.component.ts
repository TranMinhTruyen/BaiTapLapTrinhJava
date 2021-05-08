import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  account: string;
  personals: any = {
    data: [],
    page: 0,
    size: 0,
    totalPage: 0,
    totalRecord: 0
  }
  personal: any = {
    "id": 0,
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
    this.http.get("http://localhost:8080/api/khachhang/getKhachHangByKeyword/?page=1&size=2&keyword=" + this.account).subscribe(
      result => {
        let res: any = result;
        this.personals = res;
        console.log(this.personals)
        this.toastr.success('Bạn không có quyền sửa !!!', 'Lấy thông tin tài khoản thành công');
      },
      error => {
        this.toastr.error('Lỗi !', 'Không Thể Lấy Thông Tin');
        console.error(error);
      }
    )
  }
  request(){
    this.toastr.error('Lỗi !', 'Chức năng này đang được phát triển');
  }
  delete(id){
    this.http.delete("http://localhost:8080/api/khachhang/deleteKhachHang/?id=" + id).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Xóa tài khoản thành công');
        localStorage.clear();
        this.router.navigate(['/user/']);
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Xóa tài khoản thất bại');
        this.toastr.info('Hoặc Là Bạn Có Thể Liên Hệ Nhân Viên Để Biết Thêm Thông Tin');
        this.toastr.info('Vui Lòng Đơi Tiệc Kết Thúc');
        this.toastr.info('Tài Khoản của bạn đang liên kết với 1 hoặc nhiều Buổi Tiệc');
        console.error(error);
      }
    )
  }

  ngOnInit(): void {
    if (localStorage.getItem("taiKhoanKhachHang") == null) {
      this.router.navigate(['/user/']);
    };
    this.account = localStorage.getItem("taiKhoanKhachHang");
    this.personalInfo();
  }


}
