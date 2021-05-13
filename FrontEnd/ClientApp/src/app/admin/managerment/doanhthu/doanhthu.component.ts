import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Chart } from 'node_modules/chart.js';

@Component({
  selector: 'app-doanhthu',
  templateUrl: './doanhthu.component.html',
  styleUrls: ['./doanhthu.component.css']
})
export class DoanhthuComponent implements OnInit {

  constructor(private HttpClient: HttpClient,
    private modalService: NgbModal,
    private router: Router,
    private toastr: ToastrService) { }
  tiec: any = {
    "data": [],
    "totalRecord": null,
    "page": null,
    "size": null,
    "totalPage": null
  };
  nv: any = {
    "id": null,
    "thoiGian": "",
    "ngayToChuc": "",
    "loai": "",
    "trangThai": "",
    "sanh": null,
    "khachHang": null,
    "caLamViec": null,
    "menu": null,
    "soBan": 0,
    "giaTienSanh": 0,
    "giaTienMenu": 0
  }

  ngOnInit(): void {
    this.getEmployees(5, 1);
    this.tinhTien();
    var myChart = new Chart("myChart", {
      type: 'bar',
      data: {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5',
          'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
        datasets: [{
          label: '# Việt Nam Đồng',
          //data: [],
          data : [400000,500000,6000000,123134],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)',
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)',
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
  getEmployees(size: number, page: number) {
    this.HttpClient.get<any>('http://localhost:8080/api/tiec/getAllTiec/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.tiec = response;
        this.tinhTien();
        console.log("tinhtien: " + this.tiec.data);
      }
    );
  }
  subtotal: [0];
  tinhTien() {
    for (var i = 0; i < this.tiec.data.length; i++) 
      this.subtotal.push((parseInt(this.tiec.data[i].soBan) * (this.tiec.data[i].giaTienMenu))
        + this.tiec.data[i].giaTienSanh);
  }


}
