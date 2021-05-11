import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  isReadOnly: boolean;
  closeResult: string;
  closeModal: string;
  i: string;
  khachHang: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  kh: any = {
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
      console.log(this.khachHang.data[index]);
      this.kh = this.khachHang.data[index];
      this.openModel(content);
    }
    else{
      this.openModel(content);
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
    this.getCus(5, 1);
    if (localStorage.getItem("taiKhoanAdmin") == null) {
      this.router.navigate(['/admin/']);
    }
  }
  getCus(size: number, page: number) {
    this.HttpClient.get<any>('http://localhost:8080/api/khachhang/getAllKhachHang/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.khachHang = response;
      }
    );
  }
  searchNext(){
    if(this.khachHang.page < this.khachHang.totalPage){
      let nextPage = this.khachHang.page+1;
      let x={
        page:nextPage,
        size:5,
        keyword:""
      }
      this.HttpClient.get("http://localhost:8080/api/khachhang/getAllKhachHang/?page="+nextPage+ "&size=5").subscribe(result =>{
        this.khachHang = result;
        this.kh = this.khachHang.data;
      },error=>console.error(error));
    }
    else{
      this.toastr.info("Bạn đang ở trang cuối cùng !")
    }
  }

  searchPrevious(){
    if(this.khachHang.page < this.khachHang.totalPage){
      let nextPage = this.khachHang.page-1;
      let x={
        page:nextPage,
        size:5,
        keyword:""
      }
      this.HttpClient.get("http://localhost:8080/api/nhanvien/getAllKhachHang/?page="+nextPage+ "&size=5").subscribe(result =>{
        this.khachHang = result;
        this.kh = this.khachHang.data;
      },error=>console.error(error));
    }
    else{
      this.toastr.info("Bạn đang ở trang đầu tiên !")
    }
  }
  createCus() {

    this.HttpClient.post("http://localhost:8080/api/khachhang/createKhachHang", this.kh).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Tạo tài khoản thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng tạo lại', 'Tạo khách hàng thất bại');
        console.error(error);
      }
    )
  }
  updateCus(){
    this.HttpClient.put("http://localhost:8080/api/khachhang/updateKhachHang/?id=" + this.kh.id, this.kh).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Cập nhập tài khoản thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Cập nhập thất bại');
        this.toastr.info('Hãy kiểm tra xem đã đúng dữ liệu chưa !!!');
        console.error(error);
      }
    )
  }

  deleteCus(content, index, isReadOnly){
    this.kh = this.khachHang.data[index];
    this.HttpClient.delete("http://localhost:8080/api/khachhang/deleteKhachHang/?id=" + this.kh.id, this.kh).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Xóa thành công');
        window.location.reload();
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Xóa thất bại');
        console.error(error);
      }
    )
  }

}
