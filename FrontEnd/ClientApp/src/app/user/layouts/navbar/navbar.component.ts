import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { SanhComponent } from '../../sanh/sanh.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor( private matDialog: MatDialog) { }

  ngOnInit(): void {
  }
  onOpenDialogClick(){
    let dialogref = this.matDialog.open(SanhComponent,
      {
        data: {
          username: "username",
      },
      width: "700px",
      height: "700px",
      disableClose: true,
      });
    dialogref.afterClosed().subscribe(
      result => {
        //Kết quả sau khi đóng cái dialog
      }
    );
  }

}
