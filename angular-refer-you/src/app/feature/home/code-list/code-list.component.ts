import { Component, OnInit } from '@angular/core';
import {CodeService} from "../../../core/service/code.service";
import {Code} from "../../../core/models/code.model";
import {Website} from "../../../core/models/website.model";
import {WebsiteService} from "../../../core/service/website.service";
import {UserService} from "../../../core/service/user.service";
import {User} from "../../../core/models/user.model";

@Component({
  selector: 'app-code-list',
  templateUrl: './code-list.component.html',
  styleUrls: ['./code-list.component.scss']
})
export class CodeListComponent implements OnInit {

  public allCodes: Code[] | null = null;

  constructor(private codeService: CodeService, private websiteService: WebsiteService, private userService: UserService) {}

  ngOnInit(): void {
    this.codeService.allCodes$.subscribe(codes => {
      this.allCodes = codes;
    })
  }

}
