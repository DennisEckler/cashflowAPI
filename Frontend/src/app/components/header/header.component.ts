import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NgOptimizedImage } from '@angular/common';
import { NavigationButtonComponent } from '../navigation-button/navigation-button.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  standalone: true,
  imports: [NgOptimizedImage, RouterLink, NavigationButtonComponent],
})
export class HeaderComponent {
  logo = '../../../assets/Logo_Kostenbuch.png';
}
