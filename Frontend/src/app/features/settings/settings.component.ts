import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryCardComponent } from 'src/app/shared/category-card/category-card.component';
import { IdentifierChipComponent } from 'src/app/shared/identifier-chip/identifier-chip.component';
import { NavigationButtonComponent } from 'src/app/shared/navigation-button/navigation-button.component';
import { Category } from 'src/app/core/model/category';
import { CategoryService } from 'src/app/core/services/category.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Identifier } from 'src/app/core/model/identifier';

@Component({
  selector: 'app-settings',
  standalone: true,
  imports: [
    CommonModule,
    CategoryCardComponent,
    IdentifierChipComponent,
    NavigationButtonComponent,
    FormsModule,
  ],
  templateUrl: './settings.component.html',
  styleUrl: './settings.component.scss',
})
export class SettingsComponent implements OnInit {
  private categoryService = inject(CategoryService);

  categories?: Category[];
  categoryInput: string = '';

  ngOnInit() {
    this.categoryService.get().subscribe({
      next: (v) => (this.categories = v),
    });
  }

  addCategory() {
    if (this.categoryInput !== '' && this.categories) {
      const labelExist = this.categories.some(
        (category) => category.categoryLabel === this.categoryInput
      );
      if (labelExist || this.categoryInput.trim() === '') {
        window.alert('Can`t add duplicates or empty identifier');
      } else {
        this.categories.push({
          categoryID: null,
          categoryLabel: this.categoryInput,
          userID: null,
          identifier: [],
        });
        this.categoryInput = '';
      }
    }
  }

  deleteCategory(category: Category) {
    this.categories = this.categories?.filter(
      (ele) => ele.categoryLabel !== category.categoryLabel
    );
  }

  save() {}
}
