import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isHidden: boolean = true;

  constructor() { }

  ngOnInit(): void {
    if(localStorage.getItem("taiKhoanKhachHang") != null){
      this.isHidden = false;
    }
  }
  signOut(){
    //localStorage.removeItem("taiKhoanAdmin");
    localStorage.clear();
    window.location.reload();
  }

}
