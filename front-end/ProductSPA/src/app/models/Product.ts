export class Product {
    constructor(
        public id?: number,
        public units?: number,
        public price?: number,
        public name?: string,
        public cartons?: number,
        public totalCount?: number,
    ) {
    }
}
