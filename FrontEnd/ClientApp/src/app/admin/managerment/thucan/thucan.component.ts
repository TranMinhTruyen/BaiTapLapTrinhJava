import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-thucan',
  templateUrl: './thucan.component.html',
  styleUrls: ['./thucan.component.css']
})
export class ThucanComponent implements OnInit {
  isReadOnly: boolean;
  closeResult: string;
  closeModal: string;
  i: string;
  thucAn: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  ta: any = {
    "id": 1,
    "ten": "",
    "loai": "",
    "hinhAnh": "",
  }

  constructor(private HttpClient: HttpClient,
    private modalService: NgbModal,
    private router: Router,
    private toastr: ToastrService) { }

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
      this.HttpClient.get<any>('http://localhost:8080/api/thucan/getAllThucAn/?page=' + page + '&size=' + size + '').subscribe(
        response => {
          console.log(response);
          this.thucAn = response;
        }
      );
    }
    searchNext(){
      if(this.thucAn.page < this.thucAn.totalPage){
        let nextPage = this.thucAn.page+1;
        let x={
          page:nextPage,
          size:5,
          keyword:""
        }
        this.HttpClient.get("http://localhost:8080/api/thucAn/getAllThucAn/?page="+ nextPage + "&size=5").subscribe(result =>{
          this.thucAn = result;
          this.ta = this.thucAn.data;
        },error=>console.error(error));
      }
      else{
        this.toastr.info("Bạn đang ở trang cuối cùng !")
      }
    }
  
    searchPrevious(){
      if(this.thucAn.page < this.thucAn.totalPage){
        let nextPage = this.thucAn.page-1;
        let x={
          page:nextPage,
          size:5,
          keyword:""
        }
        this.HttpClient.get("http://localhost:8080/api/thucAn/getAllThucAn/?page="+ nextPage + "&size=5").subscribe(result =>{
          this.thucAn = result;
          this.ta = this.thucAn.data;
        },error=>console.error(error));
      }
      else{
        this.toastr.info("Bạn đang ở trang đầu tiên !")
      }
    }
  triggerModal(content, index, isReadOnly) {
    this.isReadOnly = isReadOnly;
    if(index !== null){
      console.log(this.thucAn.data[index]);
      this.ta = this.thucAn.data[index];
      this.openModel(content);
    }
    else{
      this.openModel(content);
    }   
  }
  createCaLamViec() {

    this.HttpClient.post("http://localhost:8080/api/thucan/createThucAn", this.ta).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Tạo thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng tạo lại', 'Tạo thất bại');
        console.error(error);
      }
    )
  }
  updateCaLamViec() {

    this.HttpClient.put("http://localhost:8080/api/thucan/updateThucAn/?id=" + this.ta.id, this.ta).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Cập Nhập thành công');
      },
      error => {
        this.toastr.error('Xin vui lòng làm lại', 'Cập nhập thất bại');
        console.error(error);
      }
    )
  }
  deleteCLV(content, index, isReadOnly){
    this.ta = this.thucAn.data[index];
    this.HttpClient.delete("http://localhost:8080/api/thucan/deleteThucAn/?id=" + this.ta.id).subscribe(
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
