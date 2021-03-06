import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-phanhoi',
  templateUrl: './phanhoi.component.html',
  styleUrls: ['./phanhoi.component.css']
})
export class PhanhoiComponent implements OnInit {
  isReadOnly: boolean;
  closeResult: string;
  closeModal: string;
  i: string;
  phanhoi: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  ph: any = {
    "id": 1,
    "noiDung": "",
    "idTiec": null,
    "idKhachHang": null
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
      this.HttpClient.get<any>('http://localhost:8080/api/phanhoi/getAllPhanHoi/?page=' + page + '&size=' + size + '').subscribe(
        response => {
          console.log(response);
          this.phanhoi = response;
        }
      );
    }
    searchNext(){
      if(this.phanhoi.page < this.phanhoi.totalPage){
        let nextPage = this.phanhoi.page+1;
        let x={
          page:nextPage,
          size:5,
          keyword:""
        }
        this.HttpClient.get("http://localhost:8080/api/phanhoi/getAllPhanHoi/?page="+ nextPage + "&size=5").subscribe(result =>{
          this.phanhoi = result;
          this.ph = this.phanhoi.data;
        },error=>console.error(error));
      }
      else{
        this.toastr.info("B???n ??ang ??? trang cu???i c??ng !")
      }
    }
  
    searchPrevious(){
      if(this.phanhoi.page < this.phanhoi.totalPage){
        let nextPage = this.phanhoi.page-1;
        let x={
          page:nextPage,
          size:5,
          keyword:""
        }
        this.HttpClient.get("http://localhost:8080/api/phanhoi/getAllPhanHoi/?page="+ nextPage + "&size=5").subscribe(result =>{
          this.phanhoi = result;
          this.ph = this.phanhoi.data;
        },error=>console.error(error));
      }
      else{
        this.toastr.info("B???n ??ang ??? trang ?????u ti??n !")
      }
    }
  triggerModal(content, index, isReadOnly) {
    this.isReadOnly = isReadOnly;
    if(index !== null){
      console.log(this.phanhoi.data[index]);
      this.ph = this.phanhoi.data[index];
      this.openModel(content);
    }
    else{
      this.openModel(content);
    }   
  }
  createCaLamViec() {

    this.HttpClient.post("http://localhost:8080/api/menu/createMenu", this.ph).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('T???o th??nh c??ng');
      },
      error => {
        this.toastr.error('Xin vui l??ng t???o l???i', 'T???o th???t b???i');
        console.error(error);
      }
    )
  }
  updateCaLamViec() {

    this.HttpClient.put("http://localhost:8080/api/phanhoi/updatePhanHoi/?idTiec="+this.ph.idTiec+"&idKhachHang=" + this.ph.idKhachHang, this.ph).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('C???p Nh???p th??nh c??ng');
      },
      error => {
        this.toastr.error('Xin vui l??ng l??m l???i', 'C???p nh???p th???t b???i');
        console.error(error);
      }
    )
  }
  deleteCLV(content, index, isReadOnly){
    this.ph = this.phanhoi.data[index];
    this.HttpClient.delete("http://localhost:8080/api/phanhoi/deletePhanHoi/?idTiec="+this.ph.idTiec+"&idKhachHang=" + this.ph.idKhachHang).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('X??a th??nh c??ng');
        window.location.reload();
      },
      error => {
        this.toastr.error('Xin vui l??ng th??? l???i', 'X??a th???t b???i');
        console.error(error);
      }
    )
  }


}
