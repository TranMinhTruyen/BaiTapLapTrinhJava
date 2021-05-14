import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-tiec',
  templateUrl: './tiec.component.html',
  styleUrls: ['./tiec.component.css']
})
export class TiecComponent implements OnInit {
  isReadOnly: boolean;
  closeResult: string;
  closeModal: string;
  i: string;
  nhanVien: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  nv: any = {
    "id": null,
    "role": null,
    "ngaySinh": null,
    "hinhAnh": null,
    "taiKhoan": "",
    "matKhau": "",
    "ho": "",
    "ten": "",
    "cmnd": "",
    "caLamViec": null
  }
  nvCre: any = {
    "role": null,
    "ngaySinh": null,
    "hinhAnh": null,
    "taiKhoan": "",
    "matKhau": "",
    "ho": "",
    "ten": "",
    "cmnd": "",
    "caLamViec": 1
  }
  caLamViecS = [
    { id: 1, label: "Sáng" },
    { id: 2, label: "Trưa" },
    { id: 3, label: "Chiều" },
    { id: 4, label: "Cả Ngày" }
  ]

  constructor(
    private HttpClient: HttpClient,
    private modalService: NgbModal,
    private router: Router,
    private toastr: ToastrService
  ) { }
  triggerModal(content, index, isReadOnly) {
    this.isReadOnly = isReadOnly;
    if(index !== null){
      console.log(this.nhanVien.data[index]);
      this.nv = this.nhanVien.data[index];
      this.openModel(content);
    }
    else{
      this.openModel(content);
    }   
  }
  searchNext(){
    if(this.nhanVien.page < this.nhanVien.totalPage){
      let nextPage = this.nhanVien.page+1;
      let x={
        page:nextPage,
        size:5,
        keyword:""
      }
      this.HttpClient.get("http://localhost:8080/api/tiec/getAllTiec/?page="+ nextPage + "&size=5").subscribe(result =>{
        this.nhanVien = result;
        this.nv = this.nhanVien.data;
      },error=>console.error(error));
    }
    else{
      this.toastr.info("Bạn đang ở trang cuối cùng !")
    }
  }

  searchPrevious(){
    if(this.nhanVien.page < this.nhanVien.totalPage){
      let nextPage = this.nhanVien.page-1;
      let x={
        page:nextPage,
        size:5,
        keyword:""
      }
      this.HttpClient.get("http://localhost:8080/api/tiec/getAllTiec/?page="+ nextPage + "&size=5").subscribe(result =>{
        this.nhanVien = result;
        this.nv = this.nhanVien.data;
      },error=>console.error(error));
    }
    else{
      this.toastr.info("Bạn đang ở trang đầu tiên !")
    }
  }
  private openModel(content){
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((res) => {
      this.closeModal = `Closed with: ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  ngOnInit(): void {
    this.getEmployees(5, 1);
    // if (localStorage.getItem("taiKhoanAdmin") != null && localStorage.getItem("taiKhoanKhachHang")!=null) {
    //   this.router.navigate(['/admin/']);
    // }
  }
  getEmployees(size: number, page: number) {
    this.HttpClient.get<any>('http://localhost:8080/api/tiec/getAllTiec/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.nhanVien = response;
      }
    );
  }
  createEmployees() {
    console.log("Ho: " + this.nvCre.ho);
    console.log("Ten: " + this.nvCre.ten);
    console.log("taiKhoan: " + this.nvCre.taiKhoan);
    console.log("matKhau: " + this.nvCre.matKhau);
    console.log("cmnd: " + this.nvCre.cmnd);
    console.log("caLamViec: " + this.nvCre.caLamViec);

    this.HttpClient.post("http://localhost:8080/api/nhanvien/createNhanVien", this.nv).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Tạo tài khoản thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng tạo lại', 'Tạo nhân viên thất bại');
        console.error(error);
      }
    )
  }
  updateEmployees(){
    this.HttpClient.put("/api/nhanvien/updateNhanVien/?id=" + this.nv.id, this.nv).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Cập nhập tài khoản thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Cập nhập nhân viên thất bại');
        this.toastr.info('Hãy kiểm tra xem đã chọn ca làm việc chưa !!!');
        console.error(error);
      }
    )
  }

  deleteEmployees(content, index, isReadOnly){
    this.nv = this.nhanVien.data[index];
    this.HttpClient.delete("http://localhost:8080/api/nhanvien/deleteNhanVien/?id=" + this.nv.id, this.nv).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Xóa tài khoản thành công');
        window.location.reload();
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Xóa nhân viên thất bại');
        console.error(error);
      }
    )
  }
}

