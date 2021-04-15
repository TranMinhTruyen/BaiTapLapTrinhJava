import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-sanh',
  templateUrl: './sanh.component.html',
  styleUrls: ['./sanh.component.css']
})
export class SanhComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data:{username: string},
              private matDialogRef: MatDialogRef<SanhComponent>) { }

  ngOnInit(): void {
  }
  ngOnDestroy(){
    this.matDialogRef.close(this.data);
  }
  onCloseClick(){
    this.matDialogRef.close();
  }

}
