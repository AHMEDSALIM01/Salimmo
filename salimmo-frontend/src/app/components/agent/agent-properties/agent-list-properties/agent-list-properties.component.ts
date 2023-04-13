import { Component, OnInit } from '@angular/core';
import {catchError, finalize, of} from "rxjs";
import {PropertyService} from "../../../../services/property/property.service";
import {Router} from "@angular/router";
import {faEye} from "@fortawesome/free-solid-svg-icons/faEye";
import {faPen} from "@fortawesome/free-solid-svg-icons/faPen";
import {faTrash} from "@fortawesome/free-solid-svg-icons/faTrash";
import {faClose} from "@fortawesome/free-solid-svg-icons";
import {faAdd} from "@fortawesome/free-solid-svg-icons/faAdd";
import {PropertyDto} from "../../../../models/property/propertyDto";

@Component({
  selector: 'app-agent-list-properties',
  templateUrl: './agent-list-properties.component.html',
  styleUrls: ['./agent-list-properties.component.css']
})
export class AgentListPropertiesComponent implements OnInit {
  eye = faEye;
  pen = faPen;
  trash = faTrash;
  close = faClose;
  add = faAdd;
  public properties:PropertyDto[]=[];
  public pageNumber:number=0;
  public hasNext = true;
  public hasPrevious = false;
  public size:number=1;
  public defaultSize = 1;
  count: number =0;
  public success:string="";
  totalPages: number=0;
  constructor(private propertyService:PropertyService,private router:Router) { }

  ngOnInit(): void {
    this.getAllProperties();
  }
  delete(id:number){
    this.propertyService.delete(id).subscribe((data)=>{
      this.success = "Property Deleted Successfully";
      this.ngOnInit();
      setInterval(()=>{
        this.success = "";
      },1000*10);
    });
  }
  navigate(path:string){
    this.router.navigate([path]);
  }
  getAllProperties(){
    this.properties = [];
    if(this.size>this.defaultSize){
      this.pageNumber=0;
    }
    this.propertyService.getAllProperties(this.pageNumber, this.size).pipe(
      catchError(error => {
        console.error(error);
        return of(null);
      }),
    ).subscribe(pageData => {
      if (pageData) {
        this.properties = pageData.content;
        this.hasNext = pageData.totalElements > ((this.pageNumber+1) * this.size);
        this.count = pageData.totalElements;
        this.totalPages = pageData.totalPages;
        this.hasPrevious = this.pageNumber > 0;
      }
      console.log(pageData)
    });
  }
  paginate(pageNum: number) {
    this.pageNumber = pageNum;
    this.hasPrevious = this.pageNumber > 0;
    this.getAllProperties();
  }
}
