import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-appbarss',
  templateUrl: './appbarss.component.html',
  styleUrls: ['./appbarss.component.css']
})
export class AppbarssComponent implements OnInit {
  isHidden: boolean = true;

  constructor(
    // private http: HttpClient,
    //  private router: Router,
    //  private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    if(localStorage.getItem("taiKhoanAdmin") != null){
      this.isHidden = false;
    }
  }
  signOut(){
    //localStorage.removeItem("taiKhoanAdmin");
    localStorage.clear();
    window.location.reload();
  }
}
