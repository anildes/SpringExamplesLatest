FROM alpine:latest
RUN apk update && apk add --no-cache \
    podman \
    fuse-overlayfs \
    shadow \
    iptables
RUN useradd -ms /bin/bash podmanuser
USER podmanuser
CMD ["podman", "--version"]

