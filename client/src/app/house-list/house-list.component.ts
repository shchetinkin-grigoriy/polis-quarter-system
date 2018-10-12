import { Component, OnInit } from '@angular/core';
import { HouseService } from '../house.service';

@Component({
  selector: 'app-house-list',
  templateUrl: './house-list.component.html',
  styleUrls: ['./house-list.component.css']
})
export class HouseListComponent implements OnInit {

  houses: Array<any>;

  constructor(private houseService: HouseService) { }

  ngOnInit() {
    this.houseService.getAll().subscribe(data => {
      this.houses = data;
    });
  }

}
