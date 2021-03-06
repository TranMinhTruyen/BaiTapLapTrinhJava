import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-calamviec',
  templateUrl: './calamviec.component.html',
  styleUrls: ['./calamviec.component.css']
})
export class CalamviecComponent implements OnInit {
  isReadOnly: boolean;
  closeResult: string;
  closeModal: string;
  i: string;
  caLamViec: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  clv: any = {
    "id": null,
    "caLam": null
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
      this.HttpClient.get<any>('http://localhost:8080/api/calamviec/getAllCaLamViec/?page=' + page + '&size=' + size + '').subscribe(
        response => {
          console.log(response);
          this.caLamViec = response;
        }
      );
    }
  triggerModal(content, index, isReadOnly) {
    this.isReadOnly = isReadOnly;
    if(index !== null){
      console.log(this.caLamViec.data[index]);
      this.clv = this.caLamViec.data[index];
      this.openModel(content);
    }
    else{
      this.openModel(content);
    }   
  }
  createCaLamViec() {

    this.HttpClient.post("http://localhost:8080/api/calamviec/createCaLamViec", this.clv).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('T???o ca l??m vi???c th??nh c??ng');
      },
      error => {
        this.toastr.error('Xin vui l??ng t???o l???i', 'T???o ca l??m th???t b???i');
        console.error(error);
      }
    )
  }
  updateCaLamViec() {
    console.log("clv: " + this.clv.caLam);

    this.HttpClient.put("/api/calamviec/updateCaLamViec/?id=" + this.clv.id, this.clv).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('C???p Nh???p th??nh c??ng');
      },
      error => {
        this.toastr.error('Xin vui l??ng l??m l???i', 'C???p nh???p ca l??m th???t b???i');
        console.error(error);
      }
    )
  }
  deleteCLV(content, index, isReadOnly){
    this.clv = this.caLamViec.data[index];
    this.HttpClient.delete("http://localhost:8080/api/calamviec/deleteCaLamViec/?id=" + this.clv.id).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('X??a t??i kho???n th??nh c??ng');
        window.location.reload();
      },
      error => {
        this.toastr.error('Xin vui l??ng th??? l???i', 'X??a nh??n vi??n th???t b???i');
        console.error(error);
      }
    )
  }
}
