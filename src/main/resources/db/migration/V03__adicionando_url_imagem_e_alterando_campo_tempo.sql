update public.servicos
set url_imagem = 'images/cabelo.webp'
where id = 1;

update public.servicos
set url_imagem = 'images/barba.webp'
where id = 2;

update public.servicos
set url_imagem = 'images/infantil.webp'
where id = 3;

update public.servicos
set url_imagem = 'images/lavagem.webp'
where id = 4;

update public.servicos
set url_imagem = 'images/hidratacao.webp'
where id = 5;

ALTER TABLE public.servicos
ALTER COLUMN Tempo_Duracao TYPE TEXT USING Tempo_Duracao::TEXT;