import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Category } from 'src/app/core/model/category';
import { Input } from '@angular/core';
import { IdentifierChipComponent } from '../identifier-chip/identifier-chip.component';
import { Identifier } from 'src/app/core/model/identifier';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-category-card',
  standalone: true,
  imports: [CommonModule, IdentifierChipComponent, FormsModule],
  templateUrl: './category-card.component.html',
  styleUrl: './category-card.component.scss',
})
export class CategoryCardComponent {
  @Input() category?: Category;
  identifierInput: string = '';

  deleteIdentifier(deleteIdentifer: Identifier) {
    if (this.category) {
      this.category.identifier = this.category.identifier.filter(
        (identifer) => identifer.identifierID !== deleteIdentifer.identifierID
      );
    }
  }

  addIdentifier() {
    if (this.identifierInput !== '') {
    }
  }

  onChange(event: any) {
    this.identifierInput = event.target.value;
  }
}
