import { Component, OnInit } from '@angular/core';
import { MovieModel } from 'app/core/movie/movie.model';
import { AccountService } from 'app/core/auth/account.service';
import { MovieService } from 'app/core/movie/movie.service';
import { FormBuilder, Validators } from '@angular/forms';

const YOUTUBE_LINK_REGEX =
  '^((?:https?:)?\\/\\/)?((?:www|m)\\.)?((?:youtube\\.com|youtu.be))(\\/(?:[\\w\\-]+\\?v=|embed\\/|v\\/)?)([\\w\\-]+)(\\S+)?$';

@Component({
  selector: 'jhi-sharing-movie',
  templateUrl: './sharing-movie.component.html'
})
export class SharingMovieComponent implements OnInit {
  movieRequest: MovieModel;
  isSavedSuccess = false;

  submitMovieForm = this.fb.group({
    movieUrl: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(50), Validators.pattern(YOUTUBE_LINK_REGEX)]]
  });

  constructor(private movieService: MovieService, private accountService: AccountService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.accountService.identity().subscribe(account => {
      this.movieRequest = new MovieModel(this.submitMovieForm.get('movieUrl').value, null, account.email, null, null, null);
    });
  }

  submitMovieUrl(): void {
    this.movieRequest.url = this.submitMovieForm.get('movieUrl').value;
    this.movieService.saveMovieUrl(this.movieRequest).subscribe(response => {});
  }
}
