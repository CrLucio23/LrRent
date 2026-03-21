import Link from 'next/link';

const links = [
  { href: '/', label: 'Home' },
  { href: '/catalogo', label: 'Catalogo' },
  { href: '/contatti', label: 'Contatti' },
];

export function Header() {
  return (
    <header className="site-header">
      <div className="container nav-shell">
        <Link href="/" className="brand">
          LrRent
        </Link>

        <nav className="nav-links">
          {links.map((link) => (
            <Link key={link.href} href={link.href}>
              {link.label}
            </Link>
          ))}
        </nav>
      </div>
    </header>
  );
}
