class Singleton {
  private members: Array<string> = [];

  public addMember(member: string) {
    this.members.push(member);
  }

  public getMembers(): Array<string> {
    return this.members;
  }
}

export default new Singleton();
