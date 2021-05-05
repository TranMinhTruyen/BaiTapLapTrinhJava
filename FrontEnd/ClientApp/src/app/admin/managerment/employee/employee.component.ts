import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  closeResult: string;
  nhanVien: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  nv: any = {
    "role": null,
    "ho": null,
    "ten": null,
    "ngaySinh": null,
    "cmnd": null,
    "caLamViec": null,
    "hinhAnh": null
  }

  constructor(
    private HttpClient: HttpClient,
    private modalService: NgbModal,
  ) { }

  ngOnInit(): void {
    this.getEmployees(5, 1);
  }
  getEmployees(size: number, page: number) {
    this.HttpClient.get<any>('http://localhost:8080/api/nhanvien/getAllNhanVien/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.nhanVien = response;
      }
    );
  }
  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
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
  onSubmit(f: NgForm) {
    const url = '/api/Student/';
    this.HttpClient.post(url, f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
  }
}
