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
    "giaTien": null
  }

  constructor() { }

  ngOnInit(): void {
  }

}
