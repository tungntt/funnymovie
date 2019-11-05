export class MovieModel {
  constructor(
    public url: string,
    public title: string,
    public sharedBy: string,
    public description: string,
    public votedUp: number,
    public votedDown: number
  ) {}
}
